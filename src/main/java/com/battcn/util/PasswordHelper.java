package com.battcn.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.battcn.platform.entity.pub.ManagerEntity;

public class PasswordHelper
{
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(ManagerEntity dto)
	{
		String salt = randomNumberGenerator.nextBytes().toHex();
		dto.setCredentialsSalt(salt);
		String newPass = new SimpleHash(algorithmName, dto.getPassword(),ByteSource.Util.bytes(dto.getAccount() + salt), hashIterations).toHex();
		dto.setPassword(newPass);
		System.out.println(newPass);
		System.out.println(salt);
	}

	public static void main(String[] args)
	{
		PasswordHelper passwordHelper = new PasswordHelper();
		ManagerEntity dto = new ManagerEntity();
		dto.setPassword("123456");
		dto.setAccount("admin");
		passwordHelper.encryptPassword(dto);
	}
}
