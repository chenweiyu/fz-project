package com.xhm.fz.component;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @Author xiumu
 * @Date 2020/5/29 14:53
 */
public class Md5PasswordEncoderImpl implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
    }

    /**
     * @param charSequence 明文
     * @param s 密文
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
    }
}
