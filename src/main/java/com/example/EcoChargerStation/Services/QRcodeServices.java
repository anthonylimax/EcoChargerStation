package com.example.EcoChargerStation.Services;

import com.example.EcoChargerStation.Exceptions.PointExceptions.PointNotFoundException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
public class QRcodeServices {
    @Autowired
    PaymentServices paymentServices;
    private BitMatrix generateQRStream(String url, String filePath) throws IOException, WriterException {
        String charset = "UTF-8";
        var qrCodeWriter = new QRCodeWriter();
        var urlCharset = new String(url.getBytes(charset), charset);
        var bitMatrix = qrCodeWriter.encode(urlCharset, BarcodeFormat.QR_CODE, 450, 450);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return bitMatrix;
    }

    public void GenerateQRCode(Long client_id, Long point_id, float value) throws IOException, WriterException, UserNotFoundException, PointNotFoundException {
        String url = "http://localhost:8080/payment/verify?id=" + client_id + "&pointid=" + point_id + "&value=" + value;
        String filePath = "./src/main/java/com/example/EcoChargerStation/pictures/QRCode_" + client_id + "_" + point_id +"_value"+ value +".png";
        generateQRStream(url, filePath);
        paymentServices.CreatePayment(client_id, point_id, value);
    }
}
