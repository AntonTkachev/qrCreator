import utils.DriveQuickstart;
import utils.GoogleDrive;
import utils.QRCode;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String... args) throws IOException, GeneralSecurityException, URISyntaxException {
        //goto link???

/*        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://console.developers.google.com/henhouse/?pb=%5B%22hh-0%22,%22drive%22,null,%5B%5D,%22https:%2F%2Fdevelopers.google.com%22,null,%5B%5D,null,%22Enable%20the%20Drive%20API%22,1,null,%5B%5D,false,false,null,null,null,null,false,null,false,false,null,null,null,%22DESKTOP%22,null,%22Quickstart%22,true,%22Quickstart%22,null,null,false%5D"));
        }*/
        DriveQuickstart drive = new DriveQuickstart();
        QRCode qrCode = new QRCode();
        HashMap<String, String> res = drive.getInfo();
        for (Map.Entry<String, String> entry : res.entrySet()) {
            String fileName = entry.getKey();
            String link = entry.getValue();
            //fixme некоторые линки могут быть папками
            qrCode.create(link, fileName);
        }
    }
}
