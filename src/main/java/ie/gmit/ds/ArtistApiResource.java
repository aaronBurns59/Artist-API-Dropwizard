package ie.gmit.ds;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import java.io.Console;
import java.util.Collection;
import java.util.HashMap;

@Path("/artists")
@Produces(MediaType.APPLICATION_JSON)
public class ArtistApiResource
{
    private HashMap<Integer, Artist> artistsMap = new HashMap<>();
    public ArtistApiResource()
    {
        Artist artist1 = new Artist(1, "Thin Lizzy", "Rock", 17);
        artistsMap.put(artist1.getArtistId(), artist1);
        Artist artist2 = new Artist(2, "Sam Cooke", "Soul", 20);
        artistsMap.put(artist2.getArtistId(), artist2);
    }
    @GET
    public Collection<Artist> getArtists()
    {
        return artistsMap.values();
    }

    @GET
    @Path("/{artistId}")
    public Artist getArtistById(@PathParam("artistId") int id)
    {
        if(artistsMap.containsKey(id));
            return artistsMap.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createArtist(Artist artist)
    {
        artistsMap.put(artist.getArtistId(), artist);   
    }
}