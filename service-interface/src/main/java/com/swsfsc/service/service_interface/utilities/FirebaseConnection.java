package com.swsfsc.service.service_interface.utilities;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

public class FirebaseConnection
{
	public String getUid(String auth_token) throws FirebaseAuthException
	{
		return "uid 1";/*
		FirebaseToken decodedToken;
		decodedToken = FirebaseAuth.getInstance().verifyIdToken(auth_token);
		return decodedToken.getUid();*/
	}
}
