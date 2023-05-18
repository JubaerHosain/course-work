package AbstractFactoryPattern;

// Abstract Product A
interface Button {
    void render();
}

// Concrete Product A1
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows button.");
    }
}

// Concrete Product A2
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a macOS button.");
    }
}

// Concrete Product A3
class LinuxOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Linux button.");
    }
}

// Abstract Product B
interface Checkbox {
    void render();
}

// Concrete Product B1
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox.");
    }
}

// Concrete Product B2
class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a macOS checkbox.");
    }
}

// Concrete Product B3
class LinuxOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Linux checkbox.");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory 2
class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Concrete Factory 3
class LinuxOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LinuxOSCheckbox();
    }
}

// Client code
public class TestOSAbstractFactory {
    public static void main(String[] args) {
        GUIFactory factory = getOSFactory(); // Determine the current operating system and create the corresponding factory

        Button button = factory.createButton();
        button.render();

        Checkbox checkbox = factory.createCheckbox();
        checkbox.render();
    }

    public static GUIFactory getOSFactory() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return new WindowsFactory();
        } else if (os.contains("mac")) {
            return new MacOSFactory();
        } else if (os.contains("linux")) {
            return new LinuxOSFactory();
        } else {
            throw new UnsupportedOperationException("Unsupported operating system.");
        }
    }
}
