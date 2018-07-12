package com.android.mytestapplication.repository.interfaces

import com.android.mytestapplication.model.InternetPost
import io.realm.RealmResults
import org.json.JSONArray
/**
 * Repository for interact with database
 *
 * This is repository is used to execute InternetPost model queries
 */
interface InternetPostRepository {

    /**
     * Save all Internet Posts from JSONArray in database
     * @param jsonObjects JSONArray : array of Internet Posts in JSON format
     * @return "true" if Internet Posts has been saved successfully or "false" if not
     */
    fun saveAllFromServer(jsonObjects: JSONArray) : Boolean

    /**
     * Find all Internet Posts from database
     * @return RealmResults<InternetPost>: found list of entities or empty
     */
    fun findAllInternetPosts() : RealmResults<InternetPost>
}