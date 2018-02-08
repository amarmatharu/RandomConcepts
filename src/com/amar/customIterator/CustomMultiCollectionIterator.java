package com.amar.customIterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomMultiCollectionIterator<T> implements Iterator {

	private Iterator<? extends Collection<T>> outerIterator;
	private Iterator<T> innerIterator;
	private T data;
	private boolean hasNext = true;

	// Default Constructor
	public CustomMultiCollectionIterator(Collection<? extends Collection<T>> collections) {
		this.outerIterator = collections.iterator();
		prepareNext();
	}

	@Override
	public boolean hasNext() {

		return hasNext;
	}

	@Override
	public Object next() {

		if (!hasNext) {
			throw new NoSuchElementException();
		}
		T tmp = this.data;
		prepareNext();
		return tmp;

	}

	private void prepareNext()
	{
		do
		{
			if(innerIterator == null || !innerIterator.hasNext())
			{
				if(outerIterator.hasNext())
				{
					innerIterator = outerIterator.next().iterator();
				}
				else
				{
					hasNext = false;
					return;
				}
			}
			
		}while(!innerIterator.hasNext());
		
		this.data = innerIterator.next();
	}
	
	
	
	

}
