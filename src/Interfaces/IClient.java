package Interfaces;

public interface IClient {
	/**
	 * Проверка на свободность имени пользователя
	 * @param name
	 * @return
	 */
	public boolean isFreeUserName(String name);
	
	/**
	 * Создание нового пользователя
	 * @param String name
	 * @param String pass
	 * @return true - если удалось создать.
	 * @return false - если произошла ошибка
	 */
	public boolean createNewUser(String name, String pass);
	
	/**
	 * Аутентификация пользователя
	 * @param String name
	 * @param String pass
	 * @return Access Token
	 * @return NULL - если аутентификация не прошла
	 */
	public String login(String name, String pass);
	
	/**
	 * Проверка живости Access Token
	 * @param accessToken
	 * @return - количество секунд, сколько будет действителен access token
	 * @return - -1, если access token просрочен
	 */
	public int login(String accessToken);
}
