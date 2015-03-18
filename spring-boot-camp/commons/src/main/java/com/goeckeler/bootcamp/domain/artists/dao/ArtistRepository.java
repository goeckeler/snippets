package com.goeckeler.bootcamp.domain.artists.dao;

import org.springframework.data.repository.CrudRepository;

import com.goeckeler.bootcamp.domain.artists.object.Artist;

/**
 * DAO for entity {@link Artist}.
 */
public interface ArtistRepository extends CrudRepository<Artist, Long>
{
}
