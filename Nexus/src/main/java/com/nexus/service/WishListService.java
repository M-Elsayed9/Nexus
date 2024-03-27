package com.nexus.service;
import com.nexus.dto.WishListDTO;
import com.nexus.entity.Office;
import com.nexus.entity.WishList;
import com.nexus.repository.OfficeRepository;
import com.nexus.repository.UserRepository;
import com.nexus.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;
    private final OfficeRepository officeRepository;
    private final UserRepository userRepository;

    @Autowired
    public WishListService(WishListRepository wishListRepository,
                           OfficeRepository officeRepository,
                           UserRepository userRepository) {
        this.wishListRepository = wishListRepository;
        this.officeRepository = officeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public WishListDTO addOfficeToWishList(Long wishListId, Long officeId) {
        WishList wishList = wishListRepository.findById(wishListId)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found"));
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new IllegalArgumentException("Office not found"));

        wishList.addOffice(office);
        WishList updatedWishList = wishListRepository.save(wishList);
        return toDTO(updatedWishList);
    }

    @Transactional
    public WishListDTO removeOfficeFromWishList(Long wishListId, Long officeId) {
        WishList wishList = wishListRepository.findById(wishListId)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found"));
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new IllegalArgumentException("Office not found"));

        wishList.removeOffice(office);
        WishList updatedWishList = wishListRepository.save(wishList);
        return toDTO(updatedWishList);
    }

    @Transactional(readOnly = true)
    public WishListDTO getWishListById(Long id) {
        WishList wishList = wishListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist not found"));
        return toDTO(wishList);
    }

    private WishListDTO toDTO(WishList wishList) {
        Set<Office> offices = Set.copyOf(wishList.getOffices());
        return new WishListDTO(wishList.getId(), wishList.getRenter().getId(), offices);
    }
}

