/**
 * 
 */
package net.iosynth.device;

/**
 * @author rradev
 *
 */
public class SamplingFixed extends Sampling {
	private long jitter;
	/**
	 * 
	 */
	public SamplingFixed() {
		//this.fixed = true;
		this.interval = 10000; // default 10s
		this.jitter   = 0;
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.device.Sampling#getInterval()
	 */
	@Override
	public long nextInterval() {
		return interval;
	}

	/* (non-Javadoc)
	 * @see net.iosynth.device.Sampling#checkParameters()
	 */
	@Override
	public void checkParameters(){
		if(interval<50){
			interval=50;
		}
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.device.Sampling#replicate()
	 */
	@Override
	public void replicate() {
		jitter = (long) (rnd.nextGaussian() * 3000 + 5000);
		if (jitter < 0) {
			jitter = 0;
		}
	}
		
	/**
	 * @param jitter Jitter to displace fixed sampling intervals.
	 */
	public void setJitter(long jitter) {
		this.jitter = jitter;
	}
	
	/**
	 * @return Jitter to displace fixed sampling intervals.
	 */
	public long getJitter(){
		return jitter;
	}
}
