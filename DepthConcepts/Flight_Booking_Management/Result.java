public class Result {
    private boolean success;
    private String message;
    private Object data;

    Result(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.data = null;
    }
    Result(boolean success, String message,Object obj) {
        this.success = success;
        this.message = message;
        this.data = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
