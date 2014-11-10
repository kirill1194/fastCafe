package Exceptions;

import serverPackege.BaseServer;

public class ExceptionProcessing {
	public static void processingSQLWorkException(SQLWorkException e) throws RequestException {
		if (e.getErrorCode() == 401) {
			throw new RequestException(401, "");
		}
		throw new RequestException(500, BaseServer.SQLERR + e.getMessage());
	}
}
