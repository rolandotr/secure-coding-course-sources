package edu.deakin.sit218.examgeneration.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordGenerator {

	public static void main(String[] args) {
		String pw_hash = BCrypt.hashpw("lecturer", BCrypt.gensalt());
		System.out.println("lecturer: "+ pw_hash);
		pw_hash = BCrypt.hashpw("student", BCrypt.gensalt());
		System.out.println("student: "+ pw_hash);
		pw_hash = BCrypt.hashpw("admin", BCrypt.gensalt());
		System.out.println("admin: "+ pw_hash);
	}
}
