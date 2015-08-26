package br.com.meu_crud.model.utils;

import java.util.Collection;

public class DataValidatorUtils {

	public static boolean hasValueAll( Object... objects ) {
		boolean result = true;
		for ( Object object : objects ) {
			result &= hasValue( object );
		}
		return result;
	}

	@SuppressWarnings( "rawtypes" )
	public static boolean hasValue( Object object ) {
		boolean result = true;
		if ( object instanceof Collection ) {
			if ( ( (Collection) object ).isEmpty() )
				result = false;
		} else if ( object == null || object.equals( "" ) )
			result = false;
		return result;
	}
}
