package cn.spirng.context;

public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
