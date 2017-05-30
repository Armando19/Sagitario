package com.sagitario.exception;

public class DatabaseExceptionCO extends AbstractExceptionCO {

   private static final long serialVersionUID = 1L;

   public DatabaseExceptionCO(String message, Throwable cause, Class<? extends Object> pOwner) {
      super(message, cause);
      this.owner = pOwner;
   }

   public DatabaseExceptionCO(String message, Class<? extends Object> pOwner) {
      super(message);
      this.owner = pOwner;
   }

   protected DatabaseExceptionCO(Throwable cause, Class<? extends Object> pOwner) {
      super(cause);
      this.owner = pOwner;
   }
}
