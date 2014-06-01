// Copyright 2009 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.deadcircuit.deadcircuitradio.util;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class PlsParser implements PlaylistParser
{
  private final BufferedReader reader;

  public PlsParser(File file) throws FileNotFoundException
  {
    this.reader = new BufferedReader(new FileReader(file), 1024);
  }

  @Override
  public List<String> getUrls()
  {
    LinkedList<String> urls = new LinkedList<String>();
    while (true)
    {
      try
      {
        String line = reader.readLine();
        if (line == null)
        {
          break;
        }
        String url = parseLine(line);
        if (url != null && !url.equals(""))
        {
          urls.add(url);
        }
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    return urls;
  }

  private String parseLine(String line)
  {
    if (line == null)
    {
      return null;
    }
    String trimmed = line.trim();
    if (trimmed.indexOf("http") >= 0)
    {
      return trimmed.substring(trimmed.indexOf("http"));
    }
    return "";
  }
}
