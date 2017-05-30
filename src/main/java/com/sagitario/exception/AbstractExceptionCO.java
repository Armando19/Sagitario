package com.sagitario.exception;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.LoggerFactory;

public abstract class AbstractExceptionCO extends Exception implements Serializable
{

    private static final long serialVersionUID = 1L;
    protected String codigoInterno;
    protected LoggerFactory logger;
    protected Class<? extends Object> owner;

    public AbstractExceptionCO(String message, Throwable cause)
    {
        super(message, cause);
    }

    public AbstractExceptionCO(String message)
    {
        super(message);
    }

    protected AbstractExceptionCO(Throwable cause)
    {
        super(cause);
    }

    public final String toString()
    {
        StringBuilder lsbMensaje = new StringBuilder();
        lsbMensaje.append("Se present� la excepci�n ");
        lsbMensaje.append(getClass().getName());
        lsbMensaje.append(" lanzada por la clase ");
        lsbMensaje.append(owner.getName());
        lsbMensaje.append(". El error detectado fue: ");
        lsbMensaje.append(this.getMessage());
        lsbMensaje.append(", el ");
        lsbMensaje.append(this.getFecha());
        lsbMensaje.append("\n");
        return lsbMensaje.toString();
    }

    protected String getFecha()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat calFormat = new SimpleDateFormat("dd/MM/yyyy");
        String scal = calFormat.format(cal.getTime());
        return scal;
    }
}
