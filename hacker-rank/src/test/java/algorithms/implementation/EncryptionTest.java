package algorithms.implementation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EncryptionTest {

    private Encryption encryption = new Encryption();

    @Test
    public void testEncryption() {
        assertThat(encryption.encode("if man was meant to stay on the ground god would have given us roots"),
                is("imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"));
        assertThat(encryption.encode("have a nice day"), is("hae and via ecy"));
        assertThat(encryption.encode("haveaniceday"), is("hae and via ecy"));
        assertThat(encryption.encode("feedthedog"), is("fto ehg ee dd"));
        assertThat(encryption.encode("chillout"), is("clu hlt io"));
        assertThat(encryption.encode("hi"), is("h i"));
    }
}
