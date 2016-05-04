package es.dominion.curso.util.criptografia;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordUtils {

	public static String encodePassword(String password) {
		StandardPasswordEncoder passEncoder = new StandardPasswordEncoder();
        return passEncoder.encode(password);
	}

//	public static void main(String[] args) {
//		System.out.println(PasswordUtils.encodePassword("admin"));
//	}
}