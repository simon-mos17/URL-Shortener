package org.example.shortener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class ShortLinkController {

    private final ShortLinkService service;

    public ShortLinkController(ShortLinkService service){
        this.service = service;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestBody ShortLinkRequest request){
        ShortLink link = service.createShortLink(request.getOriginalLink());
        return link.getShortedLink();
    }

    @GetMapping("/{shortedLink}")
    public RedirectView redirect(@PathVariable String shortedLink){
        String originalLink = service.getOriginalLink(shortedLink);

        return new RedirectView(originalLink);
    }

}
