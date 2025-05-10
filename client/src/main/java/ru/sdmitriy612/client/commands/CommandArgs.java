package ru.sdmitriy612.client.commands;

import java.util.List;

public record CommandArgs(List<String> args, List<Object> extra) {
}
