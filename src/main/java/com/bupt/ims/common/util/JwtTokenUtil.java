package com.bupt.ims.common.util;

import com.bupt.ims.entity.IMSUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {
    private static String secret = "secret";
    private static Long timeout = 7 * 24 * 60 * 60 * 1000L; // one week

    /**
     * 从数据声明中生成令牌
     * @param claims
     * @return
     */
    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + timeout);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从令牌中获取数据声明
     * @param token
     * @return
     */
    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     * @param userDetails
     * @return
     */
    public static String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     * @param token
     * @return
     */
    public static boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            if (claims == null) {
                return true;
            }
            Date expriation = claims.getExpiration();
            return expriation.before(new Date());
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     * @param token
     * @return
     */
    public static String refreshToken(String token) {
        String refreshToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("Created", new Date());
            refreshToken = generateToken(claims);
        }catch (Exception e) {
            refreshToken = null;
        }
        return refreshToken;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        IMSUser imsUser = (IMSUser)userDetails;
        String username = getUsernameFromToken(token);
        return username.equals(imsUser.getUsername()) && !isTokenExpired(token);
    }
}
