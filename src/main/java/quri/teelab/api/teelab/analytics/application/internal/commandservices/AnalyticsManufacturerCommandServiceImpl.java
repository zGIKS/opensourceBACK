package quri.teelab.api.teelab.analytics.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.analytics.domain.model.commands.UpdateManufacturerAnalyticsCommand;
import quri.teelab.api.teelab.analytics.domain.model.aggregates.ManufacturerAnalyticsAggregate;

@Service
public class AnalyticsManufacturerCommandServiceImpl {
    public ManufacturerAnalyticsAggregate handle(UpdateManufacturerAnalyticsCommand command) {
        // Aquí va la lógica de actualización del agregado ManufacturerAnalytics
        // Por ejemplo, buscar el agregado, aplicar cambios y persistir
        return new ManufacturerAnalyticsAggregate(command.getManufacturerAnalytics());
    }
}

