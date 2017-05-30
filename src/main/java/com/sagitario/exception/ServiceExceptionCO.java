package com.sagitario.exception;

public class ServiceExceptionCO extends AbstractExceptionCO {

   private static final long serialVersionUID = 1L;

   public ServiceExceptionCO(String message, Throwable cause, Class<? extends Object> pOwner) {
      super(message, cause);
      this.owner = pOwner;
   }

   public ServiceExceptionCO(String message, Class<? extends Object> pOwner) {
      super(message);
      this.owner = pOwner;
   }

   protected ServiceExceptionCO(Throwable cause, Class<? extends Object> pOwner) {
      super(cause);
      this.owner = pOwner;
   }
}
