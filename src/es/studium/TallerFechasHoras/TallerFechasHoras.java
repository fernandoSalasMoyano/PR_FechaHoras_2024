package es.studium.TallerFechasHoras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TallerFechasHoras
{

	public static void main(String[] args)
	{
		Scanner teclado = new Scanner(System.in);
		String fechaProbable;
		String fechaNacimiento;

		Date ahora, fechaInicial, fechaFinal;
		SimpleDateFormat formateador;
		// Mostrar fecha actual tal cual
		ahora= new Date();
		System.out.println("Fecha original: " + ahora);

		// Formateamos la fecha a formato europeo
		formateador = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Fecha en formato europeo: " + formateador.format(ahora));

		// Formateamos la hora hasta milisegundos
		formateador = new SimpleDateFormat("HH:mm:ss.S");
		System.out.println("Hora con milisegundos: " + formateador.format(ahora));

		// Validar mediante una función sin la fecha es correcta o no
		// Preguntar mientras no lo sea

		do
		{
			System.out.println("Dime una fecha correcta (dd/mm/aaaa):");
			fechaProbable = teclado.next();
		}while(!validarFecha(fechaProbable));
		System.out.println("Fecha correcta!!!");
		// Dada una fecha de nacimiento, calcular cuántos años, meses, días tienes

		do
		{
			System.out.println("Dame tu fecha de nacimiento (dd/mm/aaaa):");
			fechaNacimiento = teclado.next();
		}while(!validarFecha(fechaNacimiento));

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate esteInstante = LocalDate.now();
		Period periodo = Period.between(fechaNac, esteInstante);
		System.out.printf("Tu edad es: %s años, %s meses y %s días",
				periodo.getYears(), periodo.getMonths(), periodo.getDays());
		System.out.println();

		// Mostrar días entre dos fechas dadas comprobando que fecha 1 < fecha 2. Si no, mostrar error
		try
		{
			formateador = new SimpleDateFormat("dd/MM/yyyy");
			
			// Pedir la primera fecha
			do
			{
				System.out.println("Dame una primera fecha (dd/mm/aaaa):");
							fechaProbable = teclado.next();
			}while(!validarFecha(fechaProbable));
			fechaInicial = formateador.parse(fechaProbable);
			
			// Pedir la segunda fecha
			do
			{
				System.out.println("Dame una segunda fecha (dd/mm/aaaa):");
							fechaProbable = teclado.next();
			}while(!validarFecha(fechaProbable));
			fechaFinal=formateador.parse(fechaProbable);
			
			int dias = (int) ((fechaFinal.getTime()-
					fechaInicial.getTime())/86400000);
			System.out.println("Hay "+dias+" días de diferencia");
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}




		teclado.close();
	}





	private static boolean validarFecha(String fechaProbable)
	{

		try
		{
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(fechaProbable);
		}
		catch (ParseException e)
		{
			return false;
		}
		return true;
	}

}
