package com.app.controller.rest;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.SquigglesBackgroundProducer;
import nl.captcha.gimpy.DropShadowGimpyRenderer;
import nl.captcha.gimpy.FishEyeGimpyRenderer;
import nl.captcha.text.producer.DefaultTextProducer;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ResponseObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(path = "/rest/bp")
public class RestBP 
{
	final static Logger logger = Logger.getLogger(RestBP.class);
	
    /**
     * Create a Bill
     * @param apiUser    API User
     * @param customerName	Customer's name
     * @param customerMSISDN	Customer's phone number
     * @param customerIdentifierType	Type of Identifier (National ID, Registration Number, etc.)
     * @param customerIdentifier	Customer's Identifying number used by Biller (National ID Number, Queue Token, etc.)
     * @param serviceId	Service ID as agreed with Biller
     * @param totalBillAmount	Bill's total amount
     * @return  Response Object
     *          {
     *              boolean success         (true for success, false for failure)
     *              int responseCode    	(0 for successful response, Non-zero for error-codes)
     *              String responseString   (response message)
     *          }
     */
    @RequestMapping(path = "/createbill", method = RequestMethod.POST)
    public ResponseObject createBill(
    		@RequestParam(value = "apiUser", required = true) String apiUser,
            @RequestParam(value = "customerMSISDN", required = true) String customerMSISDN,
    		@RequestParam(value = "customerName", required = true) String customerName,
    		@RequestParam(value = "customerIdentifierType", required = false) String customerIdentifierType,
    		@RequestParam(value = "customerIdentifier", required = false) String customerIdentifier,
    		@RequestParam(value = "serviceId", required = true) String serviceId,
    		@RequestParam(value = "totalBillAmount", required = true) Double totalBillAmount
    		)
    {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(false);
        responseObject.setResponseCode(-1);
        responseObject.setResponseString("Unexpected error occurred. Failed to create bill of customer (" + customerMSISDN + ") for service (" + serviceId + ")");

        try
        {

            responseObject.setSuccess(true);
            responseObject.setResponseCode(0);
            responseObject.setResponseString("Bill has been created");
        }
        catch (Exception ex)
        {
            logger.error("Handled Exception", ex);
        }

        return responseObject;
    }


    @RequestMapping(path = "/gencaptcha", method = RequestMethod.POST)
    public ResponseObject generateCaptcha() throws IOException {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setSuccess(false);
        responseObject.setResponseCode(-1);
        responseObject.setResponseString("Unexpected error occurred. Failed to create Captcha");

        char[] srcChars = "0123456789".toCharArray();

        Captcha captcha = new Captcha.Builder(100, 50)
                .addText(new DefaultTextProducer(4, srcChars))
                .gimp()
                .gimp(new FishEyeGimpyRenderer())
                .addNoise()
                .addNoise()
                .addBorder()
                .build();

        String answer = captcha.getAnswer();
        System.out.println("answer=" + answer);

        BufferedImage bufferedImage = captcha.getImage();
        ImageIO.write(bufferedImage, "jpg", new File("/var/www/captcha", "c1.jpg"));

        return responseObject;
    }

}
