package com.lcastrooliveira.graphqlpluralsightdemo.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Address;
import com.lcastrooliveira.graphqlpluralsightdemo.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AddressResolver implements GraphQLResolver<Address> {

    public Address getAddress(Author author) {
        return author.getAddress();
    }

}
