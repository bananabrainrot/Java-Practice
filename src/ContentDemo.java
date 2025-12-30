import java.util.ArrayList;
import java.util.List;
import java.time.Year;

public class ContentDemo {
    public static void main(String[] args) {
        List<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java Basics", 2024, 60, "HD"));
        items.add(new VideoLecture("Advanced OOP", 2022, 90, "4K"));
        items.add(new PodcastEpisode("Tech Talk", 2025, 45, "Alice"));
        items.add(new PodcastEpisode("History Daily", 2020, 30, "Bob"));

        int currentYear = Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(item.toString() + " | LicenseCost=" + item.getLicenseCost(currentYear));

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads: " + d.getMaxDownloadsPerDay());
            }
            System.out.println("------------------------------------------------");
        }
    }
}