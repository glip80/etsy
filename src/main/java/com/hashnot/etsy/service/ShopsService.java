package com.hashnot.etsy.service;

import com.hashnot.etsy.Shops;
import com.hashnot.etsy.dto.LedgerEntry;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class ShopsService extends AbstractEtsyService {
    private Shops shops;

    public ShopsService(Executor executor, Shops shops) {
        super(executor);
        this.shops = shops;
    }

    public Observable<Response<Listing>> findAllShopListings(String shopId, Collection<String> includes, Collection<String> fields) {
        Observable<Response<Listing>> result = null;
        for (Listing.AvailableState state : Listing.AvailableState.values()) {
            Observable<Response<Listing>> observable = call(offset -> shops.findAllShopListings(shopId, state.name(), null, offset, null, includes, fields)).filter(r -> r.getCount() != 0);
            if (result != null)
                result = result.concatWith(observable);
            else
                result = observable;
        }

        return result;
    }

    public Observable<Response<Receipt>> findAllShopReceipts(
            String shopId,
            ZonedDateTime createdFrom,
            ZonedDateTime createdTo,
            Boolean paid,
            Boolean shipped,
            Collection<String> includes,
            Integer limit
    ) {
        return call(offset -> shops.findAllShopReceipts(shopId, toTimeStamp(createdFrom), toTimeStamp(createdTo), paid, shipped, includes, limit, offset, null));
    }

    /**
     * Get a Shop Payment Account Ledger's Entries
     */
    public Observable<Response<LedgerEntry>> findLedgerEntries(
            String shopId,
            ZonedDateTime minCreated,
            ZonedDateTime maxCreated,
            Integer limit
    ) {
        return call(offset -> shops.findLedgerEntries(shopId, toTimeStamp(minCreated), toTimeStamp(maxCreated), limit, offset, null));
    }

}
