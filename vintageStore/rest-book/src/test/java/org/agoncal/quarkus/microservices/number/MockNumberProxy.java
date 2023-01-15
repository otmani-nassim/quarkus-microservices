package org.agoncal.quarkus.microservices.number;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import io.quarkus.test.Mock;


@Mock
@RestClient
public class MockNumberProxy implements NumberProxy {


    @Override
    public IsbnThirteen generateIsbnNumbers() {
        IsbnThirteen isbnThirteen = new IsbnThirteen();
        isbnThirteen.isbn13 = "13-Mock";
        isbnThirteen.isbn10 = "10-Mock";
        return isbnThirteen;
    }
    
}
