public class Result<T> {
    private boolean status;
    private String message;
    private T obj;

    Result(boolean status,T obj){
        this.status = status;
        this.obj = obj;
    }
    Result(boolean status,T obj,String message){
        this.status = status;
        this.obj = obj;
        this.message = message;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public T getObj(){
        return this.obj;
    }

    public void setObj(T obj){
        this.obj = obj;
    }
}
