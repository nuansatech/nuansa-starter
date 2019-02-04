package id.nuansa.starter.base;

public class BaseController {

    protected AbstractResponseHandler abstractResponseHandler(Object object) {
        return new AbstractResponseHandler() {
            @Override
            protected Object processResponse() {
                return object;
            }
        };
    }
}