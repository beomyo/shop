package com.article.sys.util;

import org.springframework.util.DigestUtils;

public class SYS {
    //文件长传保存路径
    public static final String FILE_UPLOAD_DIR = "D:\\upload\\";

    //文件访问前缀路径 如http://localhost:8080/easyfile/0b737248-a54d-49d1-a904-20b6c31eeb7d.jpg
    public static final String FILE_UPLOAD_URL = "easyfile";

    public static final String SHOPPING_LOGIN_USER = "SHOPPING_LOGIN_USER";
    public static final String SHOPPING_LOGIN_ADMIN = "SHOPPING_LOGIN_ADMIN";

    //支付宝
    public static final String SELLER = "2088721061087501";
    public static final String PRIVATE_KET = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKjv8EE8IhS0Kfj8Wl4jf8vKLIyNCy7JGryastbKC+NrvF35hHYgZOoZZLPDvYLQeZzn+lsImUkVhOZg92qCzU60dTAxZT55DP0cc/L7Us1FXOquKGdWAYb8BT/YbycvSAPK+y2mwoBAkfbC3szPfbyqNanegdAN67wZqL2pVW40YmhGH7VL9aS7G2e2+U6c4tnZljWt9VNSDTP4FnhRq0QWv9h0HEhG5gckhp0B+w1Rtu0fioOzvQZi+B3MGriRpeLeRqVYm/JVBv29vOQl8a1hJNaicbuhvanH94ouBj+2XOmAVFnNu7d8+jNg5akPUT3Zd4uqKJtExGIDZ416tBAgMBAAECggEAYNOI9mpwUR/s0OCBuGibw2x3PWTIIyEaszfc/YNZ2VMaaS7VlZy016IoCy9uiqT9GMirfzgdDMt9MFw2Fi90FN7OGv6fTccW9YOdf1RxgYBo7mGQp3HC05DUkF0tPqSCpFLEXXIx/szDK0hH16Fs3BWBjkOm/w2qmP60Z2M61VozPDpbGstD8BAA+gfcAexKHanr6dpoRyt3ALjyJ9Fd5rfT1C5pbEdUX7yH7tRNXnQl+Dgnh3tWUVq2pHdH6xqnFCEDfBIjdL59VjI4GgGuHvy05TNWolk6yHYy/8UKG7RWjUB20jRP6tBmW8QjAcjrrJgSqrnZdbWSkse8lF1CAQKBgQDtp27ztpYmaSrRLF8BSwREAVZWGGwFpbPykSVhQomSr/VImS5E6k/Kt3sVuFtvH3kgY9qiFGhOxVpklOKzqMC+MAGoMGHUp3eZ5+UPsOIwXSMYrLwLMjEiz520yK2fF6QMcOnKU0Y4IZFdcHprVMCesfiJUhc1V6ij8+sJxCJa8QKBgQCVQTfvOqiUsou2y4Gx2+NwEau/L3xIJEPZTc6rhst+lK66OeLsRO6vcs6SzqIQ+c/0Zm+1pnG1u/H08WSjYN3KS1nQ/H0yJEoUovQzttO+oQTdpVRZesqZ/DMDq2hh7VXIUzX7nGJGuf6tP1zxH5JlCp4aWsEkBEsLOXRajXU1UQKBgQDmwcPfCvRCea1ki7P4GnIa4j2FvZLt7NaMelkUVjok34vIoUwnCGjPylbOYUMO5D2FsM9yv2QE0GYT8ekqT3pPcWe6ergTd0SPgXaORM9r7JOOevLf4C2LwpI8HvtO1fKpTd4EYdV13Uo7s2J640FhFifgloAIgIQ0JjybMAG30QKBgFW/MTZUOdOru86ZnfojfMe+ry/YRQthIkWuiMRMXY5sNvGwHellNMdBKuJ2qe8cxdcAHr96Tyt8PWZeZFXkaac1oPUKiZaL+K9gavFm4MFM2nHH8OyzOcA7fsdl60MPSdAb1hCmaGN/qYu4slmorL812V0EtJ9PhBl/uZPoXuTxAoGBAOoujRXsco5tAoK1PV+WtIQaeF1RQ33APqXi0IkhHuoZo6lIjviVWZsWubjQUjjJ6c82P7LgUlFF9KhaRcd1+9ELDqO31D8NxNEClFpryPpq/zu9UF7y7Qc7Lhw7Aj1XF+JbjCgcwqUglKX6f/rw6h4+EU22LKW1gcnboNsbXmSF";
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgW6WZQb540huFB2EZmSXpG+oIqOpqqQxtACc0uXOSTtqUbSxyx6Qu0CnBbH/sLKHbMyhLsq+zcx56luBKrRAN/4lfm0UTAyggmockk9ND66Q/GKHZ8/WTx9rz6qKMgXkWut+n7AVPHI9AXG037RS+YmGx1lJX+ZfnewQs3UplkIXccCAId9Z00mkVoxpc2yoO93H106DpyhPUaS5T7ScojzwmNeH8wAQ4UBPJ4/Xu1uB+UPUGuW2oiWO5ZPGQpn/exQL2/1ArMxEWLFhfCq3u8hwtHgij19IaTYBwsW7ZKohv1Xxj+LyXNh15Io1K1GUJOFDGmeIM46c2ovjIqEK1wIDAQAB";
    public static final String APPID = "9021000146601329";
//    public static final String SELLER = "2088721044641395";
//    public static final String PRIVATE_KET = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCtt4zbNWinILU9PkfNpGwg0PALbmkZaNnsI6eYK4XbY6wxn3NPqfGgg3NYwErpslfDNEifGREoFx0GiA1D/IvRqGSSj/S+yHqNvO+7wBqgi5w6T8hQKkiSItgz9IS5rmAWfHL5GlT2Ao+DKalQJ+J4qGDNNeepZdcmnKMPc/B+NbQ8F8/apjG0jZPhDn7VmbUTcotGVWb+X/zsn+6xrx/U3ANyAfMkTib52V5ARlCKXEx5NWqEs5vBOCRQnzf0McC6xHR3XLLnYWbU9GtLb+4Ff8GTMXT5Dl4n/nOsfMx6Emg+lII9arppwjOUG7CHdUKTHEs7l7sr0llkSOnMQpYHAgMBAAECggEBAKWmqBzIezkTiYATCalhJvLMCnr8GCBwyY3SGhiTOBuSmjrfj7fhmFW1w6JYC5d5xxKPosiDwMZ38+esiOnRwwp0ByNzPrFGvwa1qe1hLIL3XkyEk8FN8NHZhE1W19GwJFSM6536rBXDL1KlwZx7zAu+lEBbLMNuJ5HcP+mWZzgRLvXUCyxf4cJuOZwX6MhunXDaAnNlB6i8HT+OI0yTvhvQYm33U0EHRnwf3fDIaR7XSW4zznT7uE5OlLQcsnOxed3sP0MhYxfcUGzwzRKDMHVy76aBMJlVLEnZi/I2pv+mtRrEFEMfXx+xNgcXdWf3uAkk5gTez0zslCHpxmMzHRECgYEA4SpQpTLnQ9sbIcT/LuEK+UFTBCdhJCJw9cAa3UX3Qfc569wH/8/eaOkp9fFhmAvOtBl4Ijzw+TyXQCCT/82VB4il/fzbvwf8we9xIAyG1PKKNhZp69TY5FXAlONjbRRiffnxQRN4sNvM+V6jY6qLYwkkJ4bynnKk11ohZS7DQzMCgYEAxYGY48DPuUiAFikhGGPy+ytrKIVwmUkpLjSoYjcRLn4nBONyx+owtYn4Qefqt9u+j/hj+FcONUAy3cUW5mKd0JrjTD9My+MAGeBOMDAShEYoilvuXXBgzx7P6FKrgJ4i/OaSTKlejtavFPaVjf1ggTY8NWUSv1Og8KPopTXYId0CgYBJSI5q1gBzE1LnUMiFJ3V83of4aCCztAnz0gxsTCNHcwGFBF4OIkeO+aRQiblr1Rv3ffqdmhwL4m6PzoqczPpeM1ljKvMSX7UiIZ4+AhW4JSBarjzXJrVYy5gcXU206NeNjNW6im3TkhZKa0TeYVlwaD8+Jiu86i9Ab/NCjU+8BQKBgHMDaRkX6t8mzRAam18stQ521kweiNd6tzRlDblEAAlnBSnfmbO5OOw+kAcxGoo+uNX1+6FecLOp0vU6FH/M5cHYsIxyQDJq2mA3MtD07ZOBl5IavtBC5N04QDI2EhEwBYfobUGfT6U2d3ZpseWhq1UTVDRzy1sHRC1eBdhPZrExAoGAWAtXRCGJNg5Io9r8VpnMn7tYFLF4IzF+vYhoUrOf8Ijn9ERXAPhtRItvJmhO9J9YzSQ/9DfiMbMn/v+fLW+by7QwrHiY8eIdJPgiKPcnKOLey1+SOXe2FmouD+NFgxjR5vPyOgT1Lw5vpR9naqFdLzFzZttEWzKa29Che9gbMbs=";
//    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9xSpVNvnEDMNIt4aIArSByOsYpgmpOJhwr3kVvBJkrcErW1cY26APjBGOxFj5Ng1TuBatl1W72p++h0Q6gPPp2le2kulqapdqYnPpIRFHM712Y9er3ksB3NMNnxGCXjGUSMdVWU9FI9ogBXTJxM3XIhCIidrbTofNIJ3WVmTc5ZyiICu19Fq3vW37KwGahLJgWQD+YU8IQfVwA2TzR6AplsIKgSXlTOO5mV9BCLcsHAUd1cLUSospCJPYMyphjfd3ZIgUrv/WgCCfF8rMjenp1HFe7sFyc3hZyaw66wAFPX1aPRB/h6VomglsLM4uUsimvcw1fFdU2J3Ovva3GB7hwIDAQAB";
//    public static final String APPID = "9021000140673885";

    public static final char[] HEX_CHAR_ARR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final String NOTIFY_URL = " http://62ebcd28.r27.cpolar.top/checkout/notify";

    public static String digest(String pass) {
        int countIndex = (int) (Math.random() * HEX_CHAR_ARR.length);
        int saltIndex = (int) (Math.random() * HEX_CHAR_ARR.length);
        int count = HEX_CHAR_ARR[countIndex];
        char salt = (char) HEX_CHAR_ARR[saltIndex];
        char countChar = (char) count;
        pass = pass + salt;
        for (int i = 0; i < count; i++) {
            pass = DigestUtils.md5DigestAsHex(pass.getBytes());
        }
        String passwordText = salt + pass + countChar;
        return passwordText;
    }

    public static boolean checkPass(String pass, String hexPass) {
        char salt = hexPass.charAt(0);//盐值
        char countChar = hexPass.charAt(hexPass.length() - 1);
        pass = pass + salt;
        for (int i = 0; i < countChar; i++) {
            pass = DigestUtils.md5DigestAsHex(pass.getBytes());


        }
        String text = salt + pass + countChar;
        return text.equals(hexPass);
    }


}

