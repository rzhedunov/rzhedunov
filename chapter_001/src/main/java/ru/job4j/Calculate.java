package ru.job4j;
/**
* Class Calculate to illustrate JavaDoc comments.
* @author rzhedunov
* @since 2017-09-13
* @version 2.0
*/

public class Calculate {

	/**
	* Main method of Calculate class.
	* @param args is first arg.
	*/
	public static void main(String[] args) {
		System.out.println("Hello, world!");
	}

	/**
	* Method echo.
	* @param name is a name of user.
	* @return Echo plus name of user given.
	*/
	public String echo(String name) {
	    return "Echo, echo, echo : " + name;
	}
}