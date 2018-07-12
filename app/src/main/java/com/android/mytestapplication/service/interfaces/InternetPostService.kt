package com.android.mytestapplication.service.interfaces

import com.android.mytestapplication.model.InternetPost
import io.realm.RealmResults
import org.json.JSONArray
/**
 * Service for serve interact with model
 *
 * This is service is used for interact with InternetPost model
 */
interface InternetPostService {

    /**
     * Find all Internet Posts
     * @return RealmResults<InternetPost>: found list of entities or empty
     */
    fun findAllInternetPosts(): RealmResults<InternetPost>

    /**
     * Save all Internet Posts from JSONArray in database
     * @param internetPosts JSONArray : array of Internet Posts in JSON format
     * @return "true" if Internet Posts has been saved successfully or "false" if not
     */
    fun downloadInternetPostsFromServer(internetPosts: JSONArray): Boolean
}