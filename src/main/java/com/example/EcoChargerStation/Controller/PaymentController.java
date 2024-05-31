package com.example.EcoChargerStation.Controller;

import ch.qos.logback.core.model.Model;
import com.example.EcoChargerStation.Dtos.CreatePaymentDTO;
import com.example.EcoChargerStation.Dtos.ErrorBody;
import com.example.EcoChargerStation.Dtos.ReleasePayment;
import com.example.EcoChargerStation.Exceptions.PointExceptions.PointNotFoundException;
import com.example.EcoChargerStation.Exceptions.UserExceptions.UserNotFoundException;
import com.example.EcoChargerStation.Services.PaymentServices;
import com.example.EcoChargerStation.Services.QRcodeServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    QRcodeServices qrcodeServices;
    @Autowired
    PaymentServices paymentServices;

    @GetMapping("/verify")
    public ResponseEntity scanning(@RequestParam Long id, @RequestParam Long pointid, @RequestParam float value) throws UserNotFoundException, PointNotFoundException {
        try{
            if(paymentServices.ConfirmPayment(id, pointid, value)) return ResponseEntity.ok().body(new ReleasePayment("Pagamento Efetuado", "Pagamento efetuado com sucesso id: " + id));
            throw new Exception("Houve um erro");
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
        catch(PointNotFoundException e){
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorBody(HttpStatus.BAD_REQUEST.name(), e.getMessage()));
        }
    }


    @GetMapping("qrcode/{name}")
    public ResponseEntity ImageProvider(@PathVariable String name) throws MalformedURLException {
        Path newPath = Paths.get("src/main/java/com/example/EcoChargerStation/pictures/").resolve(name);
        Resource newResource = new UrlResource(newPath.toUri());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // ou MediaType.IMAGE_PNG, etc.

        return ResponseEntity.ok().headers(headers).body(newResource);


    }

    @PostMapping("/qrcode")
    public ResponseEntity GeneratePaymentQRCode(@RequestBody CreatePaymentDTO payment){
        try {
            qrcodeServices.GenerateQRCode(payment.clientId(), payment.pointId(), payment.value());
            return ResponseEntity.ok().body(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("erro");
        }
    }

}
