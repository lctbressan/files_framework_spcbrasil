package br.com.trendalytics.utils;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ManipularJson {
	public static Boolean resetKey = true;

	private static Integer keyIndex = 0;

	public static Integer jsonIndex = -1;

	public static Boolean autoGeneratedValue = false;

	public static String fieldType = "";

	public static String valorRetorno = null;

	public static Boolean isRoot = true;

	public static JSONObject jsonObject = null;

	public static String jsonKey = "";

	public static String jsonValue = "";

	public static String lerJson(String path) {

		try {
			JsonParser parser = new JsonParser();
			Object obj = parser.parse(new FileReader("./src/test/resources/json/" + path));
			JsonObject jsonObj = (JsonObject) obj;
			return jsonObj.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Irá atualizar um JSON buscando apenas pelo nome do campo.
	 * 
	 * @param jsonParam
	 *            : String contendo o JSON que será alterado
	 * @param campo
	 *            : Nome do campo que terá o seu valor alterado
	 * @param valor
	 *            : Novo valor que será adicionado ao campo
	 * @return String : Irá retornar uma string contendo o JSON atualizado
	 * @throws JSONException
	 */
	public static String alterarCampoJson(String jsonParam, String campo, String valor) throws JSONException {
		JSONObject json = new JSONObject(jsonParam);

		Iterator<String> iterator = json.keys();
		String key = null;

		while (iterator.hasNext()) {
			key = (String) iterator.next();
			// Se o objeto atual for uma string ele irá comparar o nome do campo
			// passado como parametro.
			// Se for o desejado ele irá substituir pelo valor passado como
			// parametro
			if ((json.optJSONArray(key) == null) && (json.optJSONObject(key) == null)) {
				if (key.equals(campo)) {
					json.put(key, valor);
					return json.toString();
				}
			}

			// Se o objeto atual for um JSONObject ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONObject(key) != null) {
				alterarCampoJson(json.getJSONObject(key).toString(), campo, valor);
			}

			// Se o objeto atual for um JSONArray ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONArray(key) != null) {
				JSONArray jArray = json.getJSONArray(key);
				for (int i = 0; i < jArray.length(); i++) {
					alterarCampoJson(jArray.getJSONObject(i).toString(), campo, valor);
				}
			}
		}
		return json.toString();
	}

	public static String alteraCampoJson(String jsonOriginal, String childJsonN1, String childJsonN2, String campo,
			String valor) {

		JSONObject object = null;
		try {

			object = new JSONObject(jsonOriginal);

			if (childJsonN1 != null && childJsonN2 != null) {
				object.getJSONObject(childJsonN1).getJSONObject(childJsonN2).put(campo, valor);
			} else {
				if (childJsonN1 != null && childJsonN2 == null) {
					object.getJSONObject(childJsonN1).put(campo, valor);
				} else {
					if (childJsonN1 == null && childJsonN2 == null) {
						object.put(campo, valor);
					}
				}
			}

		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return object.toString();
	}

	private static void tryToGetArray(JSONObject json, String key) {
		try {
			JSONArray lst = (JSONArray) json.get(key);

			for (Object obj : lst) {
				findJsonObject((JSONObject) obj);
			}
		} catch (ClassCastException ex) {
		} catch (JSONException ex) {
			ex.printStackTrace();
		}
	}

	private static String autoFillValue(JSONObject json) {
		String value = "";

		switch (fieldType) {
		case "CNPJ":
			value = generateCNPJ();
			break;
		case "Email":
			value = generateEmail();
			break;
		case "CPF":
			value = generateCpf();
			break;
		default:
			value = null;
			break;
		}

		return value;
	}

	public static void reset() {
		isRoot = true;
		autoGeneratedValue = false;
		keyIndex = 0;
	}

	public static void findJsonObject(JSONObject json) {
		Boolean isField = false;
		JSONObject newEntries = new JSONObject();

		if (isRoot) {
			jsonObject = json;
			isRoot = false;
		}

		JSONObject obj = null;
		String value = "";

		for (Iterator<String> it = json.keySet().iterator(); it.hasNext();) {
			value = it.next();

			if (jsonKey.equals(value)) {
				if (jsonIndex == -1 || keyIndex == jsonIndex) {
					isField = true;

					if (autoGeneratedValue) {
						newEntries.put(jsonKey, autoFillValue(json));
					} else if (jsonValue != null && !jsonValue.isEmpty())
						newEntries.put(jsonKey, jsonValue);
				}
				keyIndex++;
			}
			if (!isField)
				tryToGetArray(json, value);

			try {
				obj = json.getJSONObject(value);

				findJsonObject(obj);
			} catch (JSONException ex) {
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		for (Iterator<String> it = newEntries.keySet().iterator(); it.hasNext();) {
			String chave = it.next();

			json.put(chave, newEntries.get(chave));
		}
	}

	private static String generateCNPJ() {
		int n = 9;
		int n1 = randomiza(n);
		int n2 = randomiza(n);
		int n3 = randomiza(n);
		int n4 = randomiza(n);
		int n5 = randomiza(n);
		int n6 = randomiza(n);
		int n7 = randomiza(n);
		int n8 = randomiza(n);
		int n9 = 0;
		int n10 = 0;
		int n11 = 0;
		int n12 = 1;
		int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4
				+ n1 * 5;

		d1 = 11 - (mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4
				+ n2 * 5 + n1 * 6;

		d2 = 11 - (mod(d2, 11));

		if (d2 >= 10)
			d2 = 0;

		String retorno = null;

		retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

		return retorno;
	}

	public static String generateCpf() {
		int n = 9;
		int n1 = randomiza(n);
		int n2 = randomiza(n);
		int n3 = randomiza(n);
		int n4 = randomiza(n);
		int n5 = randomiza(n);
		int n6 = randomiza(n);
		int n7 = randomiza(n);
		int n8 = randomiza(n);
		int n9 = randomiza(n);
		int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		d1 = 11 - (mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		d2 = 11 - (mod(d2, 11));

		String retorno = null;

		if (d2 >= 10)
			d2 = 0;
		retorno = "";

		retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;

		return retorno;
	}

	public static String generateEmail() {
		return getSaltString() + "@gmail.com";
	}

	private static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}




	public static String generateCelular() {
		return "11" + getSaltStringCelular();
	}

	public static String getSaltStringCelular() {
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 9) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}


public static int diaDaSemana(int date) throws ParseException {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date ontem = sdf.parse(String.valueOf(date));
	GregorianCalendar gc = new GregorianCalendar();
	gc.setTime(ontem);
	return gc.get(GregorianCalendar.DAY_OF_WEEK);
}


	private static int randomiza(int n) {
		int ranNum = (int) (Math.random() * n);
		return ranNum;
	}


	public static String obterDataSemana(String diaSemana) throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date dataHj = new Date();
		calendar.setTime(dataHj);
		LocalDate ld = LocalDate.now();
		DayOfWeek dow = ld.getDayOfWeek();
		int value = dow.getValue();
		calendar.setFirstDayOfWeek(value);
		switch (diaSemana) {
			case "SAB":
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				break;
			case "DOM":
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				break;
			case "SEG":
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				break;
			case "TER":
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
				break;
			case "QUA":
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
				break;
			case "QUI":
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
				break;
			case "SEX":
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
				break;
			default:
				throw new Exception("Opção de menu inválida");
		}
		SimpleDateFormat format1 = new SimpleDateFormat("ddMMyyyy");
		String formatted = format1.format(calendar.getTime());
		//System.out.println(formatted);
		return  formatted;
	}

	private static int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	/**
	 * Irá atualizar um JSON buscando pelo nome do campo e um valor especifico.
	 * 
	 * @param jsonParam
	 *            : String contendo o JSON que será alterado
	 * @param campo
	 *            : Nome do campo que terá o seu valor alterado
	 * @param valorAtual
	 *            : Valor atual do campo e que será substituido
	 * @param valorNovo
	 *            : Novo valor que será adicionado ao campo
	 * @return String : Irá retornar uma string contendo o JSON atualizado
	 * @throws JSONException
	 */
	public static String alterarCampoJson(String jsonParam, String campo, String valorAtual, String valorNovo)
			throws JSONException {
		JSONObject json = new JSONObject(jsonParam);
		Iterator<String> iterator = json.keys();
		String key = null;

		while (iterator.hasNext()) {
			key = (String) iterator.next();
			// Se o objeto atual for uma string ele irá comparar o nome do campo
			// passado como parametro e o valor atual do campo.
			// Se for o desejado ele irá substituir pelo novo valor passado como
			// parametro
			if ((json.optJSONArray(key) == null) && (json.optJSONObject(key) == null)) {
				if ((key.equals(campo)) && (json.get(key).toString().equals(valorAtual))) {
					json.put(key, valorNovo);
					return json.toString();
				}
			}

			// Se o objeto atual for um JSONObject ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONObject(key) != null) {
				alterarCampoJson(json.getJSONObject(key).toString(), campo, valorAtual, valorNovo);
			}

			// Se o objeto atual for um JSONArray ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONArray(key) != null) {
				JSONArray jArray = json.getJSONArray(key);
				for (int i = 0; i < jArray.length(); i++) {
					alterarCampoJson(jArray.getJSONObject(i).toString(), campo, valorAtual, valorNovo);
				}
			}
		}
		return json.toString();
	}

	/**
	 * Irá atualizar um JSON buscando apenas pelo nome do campo. Nessa funcao
	 * ele irá alterar todos os campos do JSON que possuir com o mesmo nome do
	 * campo passado como parametro
	 * 
	 * @param jsonParam
	 *            : String contendo o JSON que será alterado
	 * @param campo
	 *            : Nome do campo que terá o seu valor alterado
	 * @param valor
	 *            : Novo valor que será adicionado ao campo
	 * @return String : Irá retornar uma string contendo o JSON atualizado
	 * @throws JSONException
	 */
	public static String alterarTodosCampoJson(String jsonParam, String campo, String valorNovo) throws JSONException {
		JSONObject json = new JSONObject(jsonParam);

		Iterator<String> iterator = json.keys();
		String key = null;

		while (iterator.hasNext()) {
			key = (String) iterator.next();
			// Se o objeto atual for uma string ele irá comparar o nome do campo
			// passado como parametro.
			// Se for o desejado ele irá substituir pelo valor passado como
			// parametro
			if ((json.optJSONArray(key) == null) && (json.optJSONObject(key) == null)) {
				if (key.equals(campo)) {
					json.put(key, valorNovo);
					return json.toString();
				}
			}

			// Se o objeto atual for um JSONObject ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONObject(key) != null) {
				alterarCampoJson(json.getJSONObject(key).toString(), campo, valorNovo);
			}

			// Se o objeto atual for um JSONArray ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONArray(key) != null) {
				JSONArray jArray = json.getJSONArray(key);
				for (int i = 0; i < jArray.length(); i++) {
					alterarCampoJson(jArray.getJSONObject(i).toString(), campo, valorNovo);
				}
			}
		}
		return json.toString();
	}

	public static String retornarValor(String jsonParam, String campo) throws JSONException {
		JSONObject json = new JSONObject(jsonParam);

		Iterator<String> iterator = json.keys();
		String key = null;

		while (iterator.hasNext()) {
			key = (String) iterator.next();
			// Se o objeto atual for uma string ele irá comparar o nome do campo
			// passado como parametro.
			// Se for o desejado ele irá substituir pelo valor passado como
			// parametro
			if ((json.optJSONArray(key) == null) && (json.optJSONObject(key) == null)) {
				if (key.equals(campo)) {
					return json.get(key).toString();
				}
			}

			// Se o objeto atual for um JSONObject ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONObject(key) != null) {
				retornarValor(json.getJSONObject(key).toString(), campo);
			}

			// Se o objeto atual for um JSONArray ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONArray(key) != null) {
				JSONArray jArray = json.getJSONArray(key);
				for (int i = 0; i < jArray.length(); i++) {
					retornarValor(jArray.getJSONObject(i).toString(), campo);
				}
			}
		}
		return json.toString();
	}

	/**
	 * Irá atualizar um JSON buscando apenas pelo nome do campo.
	 * 
	 * @param jsonParam
	 *            : String contendo o JSON que será alterado
	 * @param campo
	 *            : Nome do campo que terá o seu valor alterado
	 * @param valor
	 *            : Novo valor que será adicionado ao campo
	 * @return String : Irá retornar uma string contendo o JSON atualizado
	 * @throws JSONException
	 */
	public static String alterarCampoJson(JSONObject json, String campo, String valor) throws JSONException {
		Iterator<String> iterator = json.keys();
		String key = null;

		while (iterator.hasNext()) {
			key = (String) iterator.next();
			// Se o objeto atual for uma string ele irá comparar o nome do campo
			// passado como parametro.
			// Se for o desejado ele irá substituir pelo valor passado como
			// parametro
			if ((json.optJSONArray(key) == null) && (json.optJSONObject(key) == null)) {
				if (key.equals(campo)) {
					json.put(key, valor);
					return json.toString();
				}
			}

			// Se o objeto atual for um JSONObject ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONObject(key) != null) {
				alterarCampoJson(json.getJSONObject(key), campo, valor);
			}

			// Se o objeto atual for um JSONArray ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONArray(key) != null) {
				JSONArray jArray = json.getJSONArray(key);
				for (int i = 0; i < jArray.length(); i++) {
					alterarCampoJson(jArray.getJSONObject(i), campo, valor);
				}
			}
		}
		return json.toString();
	}

	public static String retornarValor(JSONObject json, String campo) throws JSONException {

		Iterator<String> iterator = json.keys();
		String key = null;

		while (iterator.hasNext()) {
			key = (String) iterator.next();
			// Se o objeto atual for uma string ele irá comparar o nome do campo
			// passado como parametro.
			// Se for o desejado ele irá substituir pelo valor passado como
			// parametro
			if ((json.optJSONArray(key) == null) && (json.optJSONObject(key) == null)) {
				if (key.equals(campo)) {
					valorRetorno = json.get(key).toString();
					return json.toString();
				}
			}

			// Se o objeto atual for um JSONObject ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONObject(key) != null) {
				retornarValor(json.getJSONObject(key), campo);
			}

			// Se o objeto atual for um JSONArray ele irá chamar recursivamente
			// os objetos internos
			if (json.optJSONArray(key) != null) {
				JSONArray jArray = json.getJSONArray(key);
				for (int i = 0; i < jArray.length(); i++) {
					retornarValor(jArray.getJSONObject(i), campo);
				}
			}
		}
		return json.toString();
	}
}
