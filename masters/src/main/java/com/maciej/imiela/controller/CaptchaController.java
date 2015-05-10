package com.maciej.imiela.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
@RequestMapping("/captcha/*")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @RequestMapping(value = "captcha.html", method = RequestMethod.GET)
    public void showCaptcha(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        byte[] captchaChallengeAsJpeg = null;
        // the output stream to render the captcha image as jpeg into
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        // get the session id that will identify the generated captcha.
        // the same id must be used to validate the response, the session id
        // is a good candidate!

        String sessionId = request.getSession().getId();
        // call the ImageCaptchaService getChallenge method
        BufferedImage challenge = ((ImageCaptchaService) this.captchaService)
                .getImageChallengeForID(sessionId);

        // a jpeg encoder
        ImageWriter imageWriter = ImageIO.getImageWritersBySuffix("jpeg")
                .next();
        ImageOutputStream ios = ImageIO
                .createImageOutputStream(jpegOutputStream);
        imageWriter.setOutput(ios);
        IIOMetadata imageMetaData = imageWriter.getDefaultImageMetadata(
                new ImageTypeSpecifier(challenge), null);
        imageWriter.write(imageMetaData, new IIOImage(challenge, null, null),
                null);

        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

        // flush it in the response
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        // response.setContentType("image/jpeg");
        // response.getOutputStream().write(jpegOutputStream);
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}