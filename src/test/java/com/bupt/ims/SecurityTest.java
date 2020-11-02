package com.bupt.ims;

import com.bupt.ims.common.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class SecurityTest {
    @Test
    public void BCryptTest() {
        System.out.println(BCrypt.hashpw("12345", BCrypt.gensalt()));
    }

    @Test
    public void authTokenTest() {
        // 22:29
        String header = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2MDM4OTg3NzQsInN1YiI6IjEwMDAiLCJjcmVhdGVkIjoxNjAzODk1MTc0OTg3fQ.p4YHSF8hGnGdQJciGiqlVKdhJtFHeVpY_M4-BFtY15_YVqKFufLxRASpTbI_CnVoK5uIyAUDX0z4DciBlAHQlQ";
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        System.out.println(jwtTokenUtil.getUsernameFromToken(header));
        System.out.println(JwtTokenUtil.isTokenExpired(header));
    }
}
