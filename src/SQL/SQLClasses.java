package SQL;


import java.util.ArrayList;
import java.util.Random;

import serverPackege.BaseServer;
import Exceptions.SQLWorkException;
import Functions.Functions;
import Items.MenuItem;
import Items.ProfileItem;

public class SQLClasses{
	/**
	 * Проверка на свободность имени пользователя
	 * @param phone
	 * @return
	 */
	public static boolean isFreeUserName(String phone) throws SQLWorkException{
		if (phone.equals("+79126696789"))
			return true;
		return false;
	}
	
	/**
	 * Создание нового пользователя
	 * @param String name
	 * @param String pass
	 * @return true - если удалось создать.
	 * @return false - если произошла ошибка
	 */
	public static boolean createNewUser(String phone, String pass) throws SQLWorkException{
		if (phone.equals("+79126696789"))
			return true;
		return false;
	}
	
	/**
	 * Аутентификация пользователя
	 * @param String name
	 * @param String pass
	 * @return Access Token
	 * @return NULL - если аутентификация не прошла
	 */
	public static String login(String phone, String pass) throws SQLWorkException{
		if (phone.equals("+79126696789"))
			return null;
		return Functions.md5Java(phone + ' ' + pass); 
	}
	
	/**
	 * Проверка живости Access Token
	 * @param accessToken
	 * @return - количество секунд, сколько будет действителен access token
	 * @return - -1, если access token просрочен
	 * @throws SQLWorkException: errorCode 401 - неверный Access Token - надо перелогиниться
	 */
	public static int login(String accessToken) throws SQLWorkException{
		if (accessToken.equals(BaseServer.ACCESS_TOKEN))
			return Integer.MAX_VALUE;
		return 0;
	}

	public static ArrayList<MenuItem> getMenu() throws SQLWorkException{
		ArrayList<MenuItem> arr = new ArrayList<MenuItem>();
		arr.add(new MenuItem("1", "kat", "2", "photo.jpg", "descript", 123.12));
		arr.add(new MenuItem("3", "dog", "4", "photo2.jpg", "descript2", 456.12));
		return arr;
	}
	
	/**
	 * Получение версии меню
	 * @param accessToken
	 * @return int - версия меню
	 */
	public static int getMenuVersion() throws SQLWorkException{
		Random r = new Random();
		return r.nextInt(100);
	}

	/**
	 * Получить часть меню по коду категории
	 * @param accessToken
	 * @return
	 */
	public static ArrayList<MenuItem> getMenuByCategory(String category) throws SQLWorkException{
		ArrayList<MenuItem> arr = new ArrayList<MenuItem>();
		arr.add(new MenuItem("1", "cat", category, "photo.jpg", "descript", 123.12));
		arr.add(new MenuItem("3", "dog", category, "photo2.jpg", "descript2", 456.12));
		return arr;
	}
	
	/**
	 * Получить оставшееся время жизни access token
	 * @param accessToken - String
	 * @return - int
	 * @throws SQLWorkException: errorCode 401 - неверный Access Token - надо перелогиниться
	 */
	public static int LifeTimeAccessToken(String accessToken) throws SQLWorkException{
		Random r = new Random();
		return r.nextInt(10000);
	}
	
	/**
	 * Получение профиля пользователя
	 * @param accessToken - String
	 * @return ProfileItem - профиль
	 * @throws SQLWorkException: errorCode 401 - неверный Access Token - надо перелогиниться
	 * 
	 */
	public static ProfileItem getProfile(String accessToken) throws SQLWorkException {
		return new ProfileItem("myName MySeconName", "+79126696789");
	}
	
	/**
	 * Изменение имени пользователя
	 * @param accessToken
	 * @param phone
	 * @return
	 * @throws SQLWorkException: errorCode 401 - неверный Access Token - надо перелогиниться
	 */
	public static boolean setName(String accessToken, String name) throws SQLWorkException {
		if (accessToken.equals(BaseServer.ACCESS_TOKEN))
			return false;
		return true;
	}
	
	/**
	 * Изменение пароля пользователя
	 * @param oldPass
	 * @param newPass
	 * @param accessToken
	 * @return
	 * @throws SQLWorkException: errorCode 401 - неверный Access Token - надо перелогиниться
	 */
	public static boolean changePass(String oldPass, String newPass, String accessToken) throws SQLWorkException {
		if (accessToken.equals(BaseServer.ACCESS_TOKEN))
			return false;
		return true;
	}
	
	/**
	 * Восстановление пароля
	 * @param phone
	 * @return
	 * @throws SQLWorkException
	 */
	public static boolean resetPass(String phone) throws SQLWorkException {
		if (phone.equals("+79126696789"))
			return false;
		return true;
	}
}
	
	
