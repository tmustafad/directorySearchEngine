import com.turkmen.service.impl.CacheServiceImpl;
import com.turkmen.service.impl.SearchServiceImpl;
import com.turkmen.util.AppUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class SearchEngineTest {

    public static SearchServiceImpl searchService;
    private static CacheServiceImpl cacheService;


    @BeforeAll
    static void beforeAllSetup() throws IOException {

       searchService = AppUtil.createSearchService();

       cacheService = AppUtil.createCacheService();
       cacheService.loadDirectories(Paths.get("test.txt"));
    }


    @BeforeEach
    void setUp() {
        searchService.getResultMap().clear();

    }

    @Test
    void create() {
        assertNotNull(cacheService.getCache());
    }

    @Test
    void oneHundredSuccessfull(){
        searchService.setWordFactor("that I had to use");
        assertEquals("{test.txt=100}",searchService.search("that I had to use").toString());
    }


    @Test
    void eigthypercentSuccessfull(){
        searchService.setWordFactor("that I had to xyzrtwert");
        assertEquals("{test.txt=80}",searchService.search("that I had to xyzrtwert").toString());
    }

    @Test
    void sixtypercentSuccessfull(){
        searchService.setWordFactor("that I had dasdf xyzrtwert");
        assertEquals("{test.txt=60}",searchService.search("that I had dasdf xyzrtwert").toString());
    }

}
