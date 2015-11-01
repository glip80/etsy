package com.hashnot.etsy.service;

import com.hashnot.etsy.Shops;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class ShopsService extends AbstractEtsyService {
    private Shops shops;

    public ShopsService(String apiKey, Executor executor, Shops shops) {
        super(apiKey, executor);
        this.shops = shops;
    }

    public Observable<Response<Listing>> findAllShopListings(String shopId) throws IOException {
        Observable<Response<Listing>> active = call(offset -> shops.findAllShopListings(apiKey, "active", MAX_LIMIT, offset, null));
        Observable<Response<Listing>> expired = call(offset -> shops.findAllShopListings(apiKey, "expired", MAX_LIMIT, offset, null));
        Observable<Response<Listing>> inactive = call(offset -> shops.findAllShopListings(apiKey, "inactive", MAX_LIMIT, offset, null));
        return Observable.concat(active, expired, inactive);
    }

    public Observable<Response<Receipt>> findAllShopReceipts(
            String shopId,
            Date createdFrom,
            Date createdTo,
            Boolean paid,
            Boolean shipped,
            List<String> includes,
            Integer limit
    ) throws IOException {
        return call(offset -> shops.findAllShopReceipts(shopId, createdFrom, createdTo, paid, shipped, includes, limit, offset, null));
    }

}
