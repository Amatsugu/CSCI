package LuminousVector.Utils;

public class EventNotifier
{
	private IKeyEvent e;
	private boolean eventTriggered;
	public EventNotifier (IKeyEvent event)
	{
		e = event;
		eventTriggered = false;
	}

	public void doWork ()
	{
		if (eventTriggered)
		{
			e.TriggerEvent(e.keyID);
			eventTriggered = false;
		}
	}
}
