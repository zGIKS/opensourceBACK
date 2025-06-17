package quri.teelab.api.teelab.analytics.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.analytics.domain.model.commands.UpdateCustomerAnalyticsCommand;
import quri.teelab.api.teelab.analytics.domain.model.aggregates.CustomerAnalyticsAggregate;

@Service
public class AnalyticsCustomerCommandServiceImpl {
    public CustomerAnalyticsAggregate handle(UpdateCustomerAnalyticsCommand command) {
        // Aquí va la lógica de actualización del agregado CustomerAnalytics
        // Por ejemplo, buscar el agregado, aplicar cambios y persistir
        return new CustomerAnalyticsAggregate(command.getCustomerAnalytics());
    }
}

