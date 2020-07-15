package encryptdecrypt;

interface EncryptionDecryptionMethod {

    String encryption(String data, int key);
    String decryption(String data, int key);
}

class ShiftAlgorithm implements EncryptionDecryptionMethod {

    @Override
    public String encryption(String data, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : data.toCharArray()) {
            if (ch > 64 && ch < 91) {
                ch = ch + key < 91 ? (char) (ch + key) : (char) (ch + key - 26);
                str.append(ch);
            } else if (ch > 96 && ch < 123) {
                ch = ch + key < 123 ? (char) (ch + key) : (char) (ch + key - 26);
                str.append(ch);
            } else {
                str.append(ch);
            }
        }

        return str.toString();
    }

    @Override
    public String decryption(String data, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : data.toCharArray()) {
            if (ch > 64 && ch < 91) {
                ch = ch - key > 64 ? (char) (ch - key) : (char) (ch - key + 26);
            } else if (ch > 96 && ch < 123) {
                ch = ch - key > 96 ? (char) (ch - key) : (char) (ch - key + 26);
            }
            str.append(ch);
        }

        return str.toString();
    }
}

class UnicodeAlgorithm implements EncryptionDecryptionMethod {

    @Override
    public String encryption(String data, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : data.toCharArray()) {
            str.append((char) (ch + key));
        }

        return str.toString();
    }

    @Override
    public String decryption(String data, int key) {
        StringBuilder str = new StringBuilder();

        for (char ch : data.toCharArray()) {
            str.append((char) (ch - key));
        }

        return str.toString();
    }
}
class EncoderDecoder {

    private EncryptionDecryptionMethod method;

    public void setMethod(String alg) {
        if ("shift".equals(alg)) {
            this.method = new ShiftAlgorithm();
        } else if ("unicode".equals(alg)) {
            this.method = new UnicodeAlgorithm();
        }
    }

    public String encryption(String data, int key) {
        return method.encryption(data, key);
    }

    public String decryption(String data, int key) {
        return method.decryption(data, key);
    }

    public String modeCryption(String data, int key, String mode) {
        if ("dec".equals(mode)) {
            return decryption(data, key);
        } else if ("enc".equals(mode)) {
            return encryption(data, key);
        }

        return "";
    }
}
