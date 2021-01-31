module com.heyrudy.config {
    exports com.heyrudy.config.spring;
    requires com.heyrudy.core;
    requires com.heyrudy.router.spring_router;
    requires com.heyrudy.storage.in_memory;
    requires com.heyrudy.storage.mybatis;
    requires org.mybatis;
}
