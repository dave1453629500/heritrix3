package org.archive.modules.revisit;

import static org.archive.format.warc.WARCConstants.HEADER_KEY_ETAG;
import static org.archive.format.warc.WARCConstants.HEADER_KEY_LAST_MODIFIED;
import static org.archive.format.warc.WARCConstants.HEADER_KEY_PAYLOAD_DIGEST;

import java.util.Map;

import org.archive.format.warc.WARCConstants;

public class ServerNotModifiedRevisit extends AbstractProfile {
	
	// From HTTP response
	protected String eTag;
	protected String lastModified;
	
	// Optional. Digest of original capture
	protected String payloadDigest;
	
	/**
	 * Minimal constructor.
	 */
	public ServerNotModifiedRevisit() {
	}
	
		
	@Override
	public String getProfileName() {
		return WARCConstants.PROFILE_REVISIT_NOT_MODIFIED;
	}

	@Override
	public Map<String, String> getWarcHeaders() {
		Map<String, String> headers = super.getWarcHeaders();
		
		if (payloadDigest!=null) {
			headers.put(HEADER_KEY_PAYLOAD_DIGEST, payloadDigest);
		}
		
		if (eTag!=null) {
			headers.put(HEADER_KEY_ETAG, eTag);
		}
		
		if (lastModified!=null) {
			headers.put(HEADER_KEY_LAST_MODIFIED, lastModified);
		}
		
		return headers;
	}

	public String getETag() {
		return eTag;
	}


	public void setETag(String eTag) {
		this.eTag = eTag;
	}


	public String getLastModified() {
		return lastModified;
	}


	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}


	public String getPayloadDigest() {
		return payloadDigest;
	}


	public void setPayloadDigest(String payloadDigest) {
		this.payloadDigest = payloadDigest;
	}

	
}
