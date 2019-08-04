import com.turkmen.service.CacheService;
import com.turkmen.service.impl.SearchServiceImpl;
import com.turkmen.util.AppUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppMain {


    private static CacheService  cacheService=AppUtil.createCacheService();

    private static SearchServiceImpl searchService=AppUtil.createSearchService();

    public static void main(String[] args) throws IOException {

        Files.list(Paths.get(args[0]))
                .forEach(i -> cacheService.loadDirectories(i.toAbsolutePath()));


        Scanner keyboard = new Scanner(System.in);
        while (true) {
            searchService.getResultMap().clear();
            System.out.print("search> ");
            final String line = keyboard.nextLine();
            searchService.setWordFactor(line);
            searchService.search(line);
            System.out.println(searchService.getResultMap());
        }

    }









}
