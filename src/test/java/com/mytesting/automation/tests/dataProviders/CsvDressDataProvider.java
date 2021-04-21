package com.mytesting.automation.tests.dataProviders;

import com.mytesting.automation.model.data.ContactData;
import com.mytesting.automation.model.data.DressData;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class CsvDressDataProvider implements ArgumentsAggregator {

    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
            throws ArgumentsAggregationException {
        return new DressData(
            accessor.getString(0) == null ? "" : accessor.getString(0),
            accessor.getString(1) == null ? "" : accessor.getString(1)            
            );
    }    
}
